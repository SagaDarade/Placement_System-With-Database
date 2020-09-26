<?php

require"conn.php";

//Foreign Key from 'roommaster' table

$a_id=$_GET['a_id'];
$a_name=$_GET['a_name'];			
$a_addr=$_GET['a_addr'];
$a_birthdate=$_GET['a_birthdate'];
$a_ph1=$_GET['a_ph1'];
$a_ph2=$_GET['a_ph2'];			
$a_gender=$_GET['a_gender'];
$a_ssc=$_GET['a_ssc'];		
$a_hsc=$_GET['a_hsc'];
$a_degree=$_GET['a_degree'];		
$a_pg=$_GET['a_pg'];
$a_compname=$_GET['a_compname'];
$a_compjoinig=$_GET['a_compjoinig'];
$a_comptime=$_GET['a_comptime'];

// $a_id='1';
// $a_name='omkar';			
// $a_addr='PUNE';	
// $a_birthdate='1996/05/02';
// $a_ph1='7878787878';
// $a_ph2='8787878787';			
// $a_gender='male';
// $a_ssc='45';		
// $a_hsc='55';
// $a_degree='65';		
// $a_pg='65';
// $a_compname='hcl';
// $a_compjoinig= '2020/12/12';
// $a_comptime='5pm';


$qry1="INSERT INTO admin(aid,aname,aaddress,abirthdate,aph1,aph2,agen,assc,ahsc,aug,apg,acompname,acomjoin,acomtime) VALUES ('$a_id','$a_name','$a_addr',$a_birthdate,'$a_ph1','$a_ph2','$a_gender','$a_ssc','$a_hsc','$a_degree','$a_pg','$a_compname','$a_compjoinig','$a_comptime');";

if(($conn->query($qry1) === TRUE))
{
	echo json_encode(array("response"=>"ok"));
}
else{
	echo json_encode(array("response"=>"fail"));
}

$conn->close();

?>