<!doctype html>
<html>
	<head>
		
		<meta charset="utf-8"/>
		<!--<script src="../projet.js" type="text/javascript"></script>-->
	</head>
	<body>
<?php
//session_start();

include_once('../../Controleur/requet6.php');
	echo "<h3>Liste de tout les elements</h3>";
		
		if(isset($_SESSION['Listelem'])&& (!empty($_SESSION['Listelem'])))
		{
			foreach ($_SESSION['Listelem'] as $element)
			{   echo '<div class="">';
				echo "<b>Identifiant </b>:".$element['ID'].'<br/>';
				echo "<b>Materiel</b>	  :".$element['Materiel'].'<br/>';
				echo "</div>";
				}
			//echo "est ".$_SESSION['Listelem'];
			unset($_SESSION['Listelem']);
		}
?>
<form method="POST" action="../../Controleur/retour.php" >
  <input type="submit" value="Retour"/>
</form>
</body>