<?php
session_start();
?>
<doctype html>
<html>
<head>
	<title>Liste des ARI</title>
	<meta charset="utf-8">
</head>
<body>
	<h3>La liste de tous les ARI</h3>
	<?php
		include_once('../../Controleur/requet1.php');
		if(isset($_SESSION['listAri'])&&(!empty($_SESSION['listAri'])))
		{
			foreach($_SESSION['listAri'] as $element)
			{
				echo '<b>Identifiant  : </b>'.$element['ID'].'<br/>';
				echo '<b>Etat de Gonflage : </b>'.$element['Etat Gonflage'].'<br/>';
				echo '<b>Lieu de Stock : </b>'.$element['Lieu de stock'].'<br/>';
				echo '<b>Reparation : </b>'.$element['Réparation'].'<br/>';
				echo '<b>Controle : </b>'.$element['Contrôle'].'<br/>';
				echo '<b>Utilisation : </b>'.$element['Utilisation'].'<br/>';
				echo '<b>Vehicule : </b>'.$element['Vehicule'].'<br/>';

			}
			unset($_SESSION['listAri']);
		}
	?>
	<form method="POST" action="../../Controleur/retour.php">
	  <input type="submit" value="Retour"/>
	 </form>
</body>
</html>