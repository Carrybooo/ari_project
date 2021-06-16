<?php
session_start();
?>
<doctype html>
<html>
<head>
	<title>Liste des Compresseurs</title>
	<meta charset="utf-8">
</head>
<body>
	<h3>Liste de tous les Compresseurs</h3>
	<?php
		include_once('../../Controleur/requet4.php');
		if(isset($_SESSION['ListComp'])&&(!empty($_SESSION['ListComp'])))
		{
			foreach($_SESSION['listComp'] as $element)
			{
				echo '<b>Identifiant : </b>'.$element['ID'].'<br/>';
				echo '<b>Fonctionnel : </b>'.$element['Fonctionnel'].'<br/>';
				echo '<b>Lieu de stock : </b>'.$element['Lieu de stock'].'<br/>';
				echo '<b>Reparation : </b>'.$element['Réparation'].'<br/>';
				echo '<b>Contrôles : </b>'.$element['Contrôles'].'<br/>';
				echo '<b>Utilisation : </b>'.$element['Utilisation'].'<br/>';
				echo '<b>Vehicule : </b>'.$element['Vehicule'].'<br/>';
			}
			unset($_SESSION['ListComp']);
		} 
	?>
	<form method="POST" action="../../Controleur/retour.php">
	  <input type="submit" value="Retour"/>
	 </form>
</body>
</html>