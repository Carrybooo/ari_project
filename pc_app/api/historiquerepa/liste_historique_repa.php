<?php
require_once '../config.php';
try {
    $dataArray = array();
    $reponse = $bdd->query("SELECT * FROM historiquerepa");
    $donnees = $reponse->fetchALL();
    header ('Content-Type: application/json');
    foreach ($donnees as $key => $value) {
        $dataArray[$key]['id'] = $donnees[$key]['id'];
        $dataArray[$key]['date'] = $donnees[$key]['date'];
    }
    echo json_encode(array(
        'historique_repa'=> $dataArray,
    ));

} catch (Exception $e) {
    echo $e->getMessage();
}
