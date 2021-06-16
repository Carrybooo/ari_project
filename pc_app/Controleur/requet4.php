<?php 
include_once('../../Modele/requete.php');
$_SESSION['listComp']=listComp();
if(!empty($_SESSION['listComp']))
{
	foreach($_SESSION['listComp'] as $cle=>$element)
	{
		$_SESSION['listComp'][$cle]['ID']=htmlspecialchars($element['ID']);
		$_SESSION['listComp'][$cle]['Fonctionnel']=htmlspecialchars($element['Fonctionnel']);
		$_SESSION['listComp'][$cle]['Lieu de stock']=htmlspecialchars($element['Lieu de stock']);
		$_SESSION['listComp'][$cle]['Réparation']=htmlspecialchars($element['Réparation']);
		$_SESSION['listComp'][$cle]['Contrôles']=htmlspecialchars($element['Contrôles']);
		$_SESSION['listComp'][$cle]['Utilisation']=htmlspecialchars($element['Utilisation']);
		$_SESSION['listComp'][$cle]['Vehicule']=htmlspecialchars($element['Vehicule']);
	}
}
//header("location:../../index.php?page=listComp");

?>