<?php 
include_once('../../Modele/requete.php');
$_SESSION['listContr']=listContr();
if(!empty($_SESSION['listContr']))
{
	foreach($_SESSION['listContr'] as $cle=>$jourP)
	{
		
		$_SESSION['listContr'][$cle]['IDControl']=htmlspecialchars($jourP['IDControl']);
		$_SESSION['listContr'][$cle]['Date']=htmlspecialchars($jourP['Date']);
		$_SESSION['listContr'][$cle]['Executeur']=htmlspecialchars($jourP['Executeur']);
	}
}
else //echo "données introuvable!!!";
?>