<!--?php
session_start();
?-->
<doctype html>
<html>
<head>
	<title>Liste des Controles</title>
	<meta charset="utf-8">
</head>
<body>
	<h3>La liste de tous les Controles</h3>
	<?php
		include_once('../../Controleur/requet5.php');
		if(isset($_SESSION['listContr'])&&(!empty($_SESSION['listContr'])))
		{
			foreach($_SESSION['listContr'] as $element)
			{
				echo '<b>Identifiant  : </b>'.$element['IDControl'].'<br/>';
				echo '<b>Date : </b>'.$element['Date'].'<br/>';
				echo '<b>Executeur : </b>'.$element['Executeur'].'<br/>';
			}
			unset($_SESSION['listContr']);
		}
	?>
	<form method="POST" action="../../Controleur/retour.php">
	  <input type="submit" value="Retour"/>
	 </form>
</body>
</html>