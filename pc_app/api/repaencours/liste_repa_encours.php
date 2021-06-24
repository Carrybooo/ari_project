<?php
require_once '../config.php';
try {
    $dataArray = array();
    $reponse = $bdd->query("SELECT * FROM repaencours");
    $donnees = $reponse->fetchALL();
    header ('Content-Type: application/json');
    foreach ($donnees as $key => $value) {
        $dataArray[$key]['id'] = $donnees[$key]['id'];
        $dataArray[$key]['lieu_stock'] = $donnees[$key]['lieu_stock'];
        $dataArray[$key]['executeur'] = $donnees[$key]['executeur'];
    }
    echo json_encode(array(
        'liste_repa_encours'=> $dataArray,
    ));

} catch (Exception $e) {
    echo $e->getMessage();
}
