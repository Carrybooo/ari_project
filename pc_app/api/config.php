<?php
try{
    $bdd = new PDO('mysql:host=localhost;dbname=poseidon', 'root','');

}
catch(Exception $e){
echo $e->getMessage();
}