<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript" src="../jQuery/jquery-1.8.3.min.js"></script>
<style type="text/css">

${demo.css}
		</style>
		<script type="text/javascript">
		
		
/*****************折线图******************/
		
		$(function () {
			
		    var seriesOptions = [],
		    	series = new Array(),
		        seriesCounter = 0,
		        testname = ['PM2.5', 'PM10', '其它'],
		        names = ['MSFT', 'AAPL', 'GOOG'],
		        // create the chart when all data is loaded
		        createChart = function () {

		            $('#container1').highcharts('StockChart', {

		                rangeSelector: {
		                    selected: 4
		                },
		                credits:{
		                	enabled: false
		                },
		                title: {
		                    text: '北京市污染物含量趋势图'
		                },
		                xAxis: {
		                	/*
		                    labels: {
		                        rotation : -50,//旋转-50度，解决SVG字太拥挤的问题
		                        y : 50
		                    },
		                    */
		                    dateTimeLabelFormats: {
		                        millisecond: '%Y-%m-%d %H:%M:%S',
		                        second: '%Y-%m-%d %H:%M:%S',
		                        minute: '%Y-%m-%d %H:%M',
		                        hour: '%Y-%m-%d %H:%M',
		                        day: '%Y-%m-%d',
		                        week: '%Y-%m-%d',
		                        month: '%Y-%m',
		                        year: '%Y'
		                    }
		                },
		                
		                yAxis: {
		                    labels: {
		                        formatter: function () {
		                            //return (this.value > 0 ? ' + ' : '') + this.value + '%';
		                            return this.value;
		                        }
		                    },
		                    plotLines: [{
		                        value: 0,
		                        color: 'green',
		                        dashStyle : 'shortdash',
		                        width: 2,
		                        //color: 'silver'
		                        label:{
		                        	text:'良好'
		                        }
		                    },
		                    {
		                        value: 60,
		                        color: 'red',
		                        dashStyle : 'shortdash',
		                        width: 2,
		                        //color: 'silver'
		                        label:{
		                        	text:'严重污染'
		                        }
		                    }
		                    ]
		                },

		                plotOptions: {
		                    series: {
		                        compare: 'percent'
		                    }
		                },

		                tooltip: {
		                    pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> <br/>',
		                    valueDecimals: 2
		                },
						
						scrollbar:{
							enable : false
						},
		                
		                spline: {
		                	enable : true
		                },
		                
		                series: series//seriesOptions
		            });
		        };

		    $.each(names, function (i, name) {

		        $.getJSON(encodeURI("line.action"),
		        			function (data) {
		        	
					        	var obj = eval('(' + data + ')');
								var categories = obj[0].month;
								var series = new Array();
								//遍历数据，封装成highcharts所需要的格式
								for ( var i = 0; i < obj.length; i++) {
									var o = new Object();
									o.name = obj[i].name;
									o.data = obj[i].answer;
									series.push(o);
								}
		        	
		        	
		        	/*

					            seriesOptions[i] = {
					                name: testname[i],
					                data: data
					            };

		            // As we're loading the data asynchronously, we don't know what order it will arrive. So
		            // we keep a counter and create the chart when all the data is loaded.
		            seriesCounter += 1;

		            if (seriesCounter === names.length) {
		                createChart();
		            }
		            */
		        });
		    });
		});
		
</script>
<script src="../js/highstock.js"></script>
<script src="../js/exporting.js"></script>
<script src="../js/highcharts-more.js"></script>
<script src="../js/highcharts-3d.js"></script>
<script src="../js/solid-gauge.js"></script>
<script src="../js/data.js"></script>
<script src="../js/drilldown.js"></script>
<script src="../js/funnel.js"></script>

<body>
<div id="container1" style="height: 400px; width: 1000px; margin: 0 auto"></div><br/><br/>

</body>
</html>