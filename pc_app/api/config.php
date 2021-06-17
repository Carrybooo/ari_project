<?php
try{
    $bdd = new PDO('mysql:host=localhost;dbname=poseidon', 'root','');
    echo "Succesful Login";
}
catch(Exception $e){
echo $e->getMessage();
}