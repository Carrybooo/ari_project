<?php
require_once '../config.php';
try {
    $dataArray = array();
    $reponse = $bdd->query("SELECT * FROM repaprevu");
    $donnees = $reponse->fetchALL();
    header ('Content-Type: application/json');
    foreach ($donnees as $key => $value) {
        $dataArray[$key]['id'] = $donnees[$key]['id'];
        $dataArray[$key]['lieu_stock'] = $donnees[$key]['lieu_stock'];
        $dataArray[$key]['executeur'] = $donnees[$key]['executeur'];
        $dataArray[$key]['date'] = $donnees[$key]['date'];
    }
    echo json_encode(array(
        'liste_repa_prevu'=> $dataArray,
    ));

} catch (Exception $e) {
    echo $e->getMessage();
}
