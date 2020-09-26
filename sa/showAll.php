<?php

require "conn.php";

$que = "SELECT * FROM `login_info`;";

$result = mysqli_query($conn,$que);

$rows = array();

	while($r = mysqli_fetch_assoc($result)){
	
	$rows[] = $r;
	}
	echo json_encode($rows);
	
	mysqli_close($conn);

?>