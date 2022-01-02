/* globals Chart:false, feather:false */

(function () {
  'use strict'

  feather.replace({ 'aria-hidden': 'true' })

  // Graphs
  var ctx = document.getElementById('myChart')
  // eslint-disable-next-line no-unused-vars
  var myChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: [
    	  '09:00PM',
          '12:00PM',
          '03:00PM',
          '06:00PM',
          '09:00PM',
          '12:00AM',
          '03:00AM',
          '06:00AM',
          '09:00AM',
          '12:00PM'
      ],
      datasets: [{
        data: [
        	24.21,
        	23.61,
        	24.72,
        	31.42,
        	33.76,
        	28.64,
        	23.76,
        	23.26,
        	22.29,
        	21.35
        ],
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })
})()
