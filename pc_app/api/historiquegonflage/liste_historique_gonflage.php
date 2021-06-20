<?php
require_once '../config.php';
try {
    $dataArray = array();
    $reponse = $bdd->query("SELECT * FROM historiquegonflage");
    $donnees = $reponse->fetchALL();
    header ('Content-Type: application/json');
    foreach ($donnees as $key => $value) {
        $dataArray[$key]['ari'] = $donnees[$key]['ari'];
        $dataArray[$key]['date'] = $donnees[$key]['date'];
        $dataArray[$key]['lieu'] = $donnees[$key]['lieu'];
        $dataArray[$key]['compresseur'] = $donnees[$key]['compresseur'];
    }
    echo json_encode(array(
        'comp_list'=> $dataArray,
    ));

} catch (Exception $e) {
    echo $e->getMessage();
}
