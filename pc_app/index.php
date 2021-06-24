<!Doctype html>
<?php
	session_start();
	?>
<html>
<head>
	<link rel="stylesheet" href="../../style.css" media="screen" type="text/css" />	
	<meta charset="utf-8"/>
<title>Poseidon</title>
</head>
<body>
<?php
if ($_SESSION['connecte']!="oui"){
	header('location:index1.html');
}
else{
	if ((isset($_GET['page']))&&(!empty($_GET['page'])))
	{
		if($_GET['page']=="listelem")
		{
			include_once('Vues/HtmlPhp/Affielement.php');
		}
	}	
	//if ((isset($_SESSION['listAri']) and !empty($_SESSION['listAri']))
	{
	
	}
		//include_once('Vues\PHP\header.html');
		include_once('Vues/projet.html');
		//include_once('Vues\PHP\footer.html');
	
		echo '<a href="./logout.php">Se déconnecter</a>';
}
	?>

</body>
</html>
