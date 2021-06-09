<!--?php
session_start();
?-->
<doctype html>
<html>
<head>
	<title>Liste des Reparation</title>
	<meta charset="utf-8">
</head>
<body>
	<h3>La liste de toutes les reparations</h3>
	<?php
		include_once('../../Controleur/requet3.php');
		if(isset($_SESSION['listRep'])&&(!empty($_SESSION['listRep'])))
		{
			foreach($_SESSION['listRep'] as $element)
			{
				echo '<b>Identifiant  : </b>'.$element['IDRepa'].'<br/>';
				echo '<b>Reparation en demande : </b>'.$element['En demande'].'<br/>';
				echo '<b>Reparation prévue : </b>'.$element['Prévue'].'<br/>';
				echo '<b>Reparation en cours : </b>'.$element['En cours'].'<br/>';
				echo '<b>Reparation terminée : </b>'.$element['Terminée'].'<br/>';
			}
			unset($_SESSION['listRep']);
		}
	?>
	<form method="POST" action="../../Controleur/retour.php">
	  <input type="submit" value="Retour"/>
	 </form>
</body>
</html>