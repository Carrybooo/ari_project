<?php
require_once '../config.php';
try {
    $dataArray = array();
    $reponse = $bdd->query("SELECT * FROM reparations");
    $donnees = $reponse->fetchALL();
    header ('Content-Type: application/json');
    foreach ($donnees as $key => $value) {
        $dataArray[$key]['id'] = $donnees[$key]['id'];
        $dataArray[$key]['en_demande'] = $donnees[$key]['en_demande'];
        $dataArray[$key]['prevue'] = $donnees[$key]['prevue'];
        $dataArray[$key]['en_cours'] = $donnees[$key]['en_cours'];
        $dataArray[$key]['terminee'] = $donnees[$key]['terminee'];
    }
    echo json_encode(array(
        'liste_repa'=> $dataArray,
    ));

} catch (Exception $e) {
    echo $e->getMessage();
}
