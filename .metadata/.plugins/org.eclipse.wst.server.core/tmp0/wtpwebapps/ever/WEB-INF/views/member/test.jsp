<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>테스트</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#searchBtn").on("click", function() {
			const pageNo = $("#pageNo").val();
			const numOfRows = $("#numOfRows").val();
			
			getCovidData(pageNo, numOfRows);
		});

	});
	
	function getCovidData(pageNo, numOfRows) {
		// 코로나 정보 가져오기
		$.ajax({
			url: "/openapi/test",
			method: "get",
			data: {
				pageNo: pageNo,
				numOfRows: numOfRows
			},
			success: function(result) {
				console.log(result);
				
				$("#tbody").html("");
				
				for(let i = 0; i < result[0].covidList.length; i++) {					
					let covidList = result[0].covidList[i];
					
					let info = `
					    <tr>
					      <th scope="row">${"${covidList.seq}"}</th>
					      <td>${"${covidList.deathcnt}"}</td>
					      <td>${"${covidList.decidecnt}"}</td>
					      <td>${"${covidList.createdt}"}</td>
					      <td>${"${covidList.updatedt}"}</td>
					    </tr>					
					`;
					
					"" + info + '' ``
					
					
					$("#tbody").append(info);
				}
				
				
			  const labels = new Array();


			  
			  for(let i = 0; i < result[0].covidList.length; i++) {
				  let createdt =  result[0].covidList[i].createdt;
				  let decidecnt =  result[0].covidList[i].decidecnt;
				  createdt = createdt.split(" ")[0];
				  labels.push(createdt);
			  }
			  
			  const data = {
			    labels: labels,
			    datasets: [{
			      label: 'My First dataset',
			      backgroundColor: 'rgb(255, 99, 132)',
			      borderColor: 'rgb(255, 99, 132)',
			      data: [0, 10, 5, 2, 20, 30, 45],
			    }]
			  };
			  
			  console.log("test : " + data.datasets[0].data);
			  
			  const config = {
			    type: 'line',
			    data: data,
			    options: {}
			  };
			  
			  const myChart = new Chart(
			    document.getElementById('myChart'),
			    config
			  );
				
			}
		});
	}
</script>
</head>
<body>

<input id="pageNo" type="text">
<input id="numOfRows" type="text">
<button id="searchBtn">검색</button>

<table class="table">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">사망자 수</th>
      <th scope="col">확진자 수</th>
      <th scope="col">등록일</th>
      <th scope="col">수정일</th>
    </tr>
  </thead>
  <tbody id="tbody">

  </tbody>
</table>

<div style="width: 900px; height: 900px;">
	<!--차트가 그려질 부분-->
	<canvas id="myChart"></canvas>
</div>


</body>
</html>