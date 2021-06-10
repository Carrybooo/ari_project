<?php 
Session_start();
include_once('../../Modele/requete.php');
$_SESSION['listComp']=listComp();
if(!empty($_SESSION['listComp']))
{
	foreach($_SESSION['listComp'] as $cle=>$art)
	{
		$_SESSION['listComp'][$cle]['ID']=htmlspecialchars($art['ID']);
		$_SESSION['listComp'][$cle]['Etat Gonflage']=htmlspecialchars($art['Etat Gonflage']);
		$_SESSION['listComp'][$cle]['Lieu de Stock']=htmlspecialchars($art['Lieu de Stock']);
		$_SESSION['listComp'][$cle]['Réparation']=htmlspecialchars($art['Réparation']);
		$_SESSION['listComp'][$cle]['Contrôle']=htmlspecialchars($art['Contrôle']);
		$_SESSION['listComp'][$cle]['Utilisation']=htmlspecialchars($art['Utilisation']);
	}
}
//header("location:../../index.php?page=listComp");

?>