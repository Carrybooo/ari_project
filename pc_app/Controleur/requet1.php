<?php 
Session_start();
include_once('../../Modele/requete.php');
$_SESSION['listAri']=listeAri();
if(!empty($_SESSION['listAri']))
{
	foreach($_SESSION['listAri'] as $cle=>$art)
	{
		$_SESSION['listAri'][$cle]['ID']=htmlspecialchars($art['ID']);
		$_SESSION['listAri'][$cle]['Etat Gonflage']=htmlspecialchars($art['Etat Gonflage']);
		$_SESSION['listAri'][$cle]['Lieu de Stock']=htmlspecialchars($art['Lieu de Stock']);
		$_SESSION['listAri'][$cle]['Réparation']=htmlspecialchars($art['Réparation']);
		$_SESSION['listAri'][$cle]['Contrôle']=htmlspecialchars($art['Contrôle']);
		$_SESSION['listAri'][$cle]['Utilisation']=htmlspecialchars($art['Utilisation']);
	}
}
//header("location:../../index.php?page=listAri");

?>