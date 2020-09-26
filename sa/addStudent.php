<?php

require"conn.php";

//Foreign Key from 'roommaster' table

$s_name=$_GET['s_name'];			
$s_addr=$_GET['s_addr'];
$s_birthdate=$_GET['s_birthdate'];
$s_ph1=$_GET['s_ph1'];
$s_ph2=$_GET['s_ph2'];			
$s_gender=$_GET['s_gender'];
$s_ssc=$_GET['s_ssc'];		
$s_hsc=$_GET['s_hsc'];
$s_degree=$_GET['s_degree'];		
$s_pg=$_GET['s_pg'];

// $s_name='omkar';			
// $s_addr='PUNE';	
// $s_birthdate="1996/05/02";
// $s_ph1='7878787878';
// $s_ph2='8787878787';			
// $s_gender='male';
// $s_ssc='45';		
// $s_hsc='55';
// $s_degree='65';		
// $s_pg='65';

$qry1="INSERT INTO student(sname,saddress,sbirthdate,smobile,smobile2,sgender,ssc,hsc,degree,pg) VALUES ('$s_name','$s_addr',$s_birthdate,'$s_ph1','$s_ph2','$s_gender','$s_ssc','$s_hsc','$s_degree','$s_pg');";

if(($conn->query($qry1) === TRUE))
{
	echo json_encode(array("response"=>"ok"));
}
else{
	echo json_encode(array("response"=>"fail"));
}

$conn->close();

?>