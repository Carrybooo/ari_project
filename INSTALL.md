Ce projet possède deux parties distinctes. <br/>
La première est une interface web, hébergée à l'adresse "adresse" (TO UPDATE), permettant d'accéder rapidement aux fonctionnalités depuis un navigateur.


La seconde partie est une application mobile. <br/>
Elle est installable via le fichier .apk situé à la racine de ce projet. Pour plus d'info :<br/>
<a href="https://www.frandroid.com/comment-faire/tutoriaux/184151_comment-installer-un-fichier-apk-sur-son-terminal-android">Installer un fichier APK</a>
  

  
Ou vous pouvez également décider de la compiler vous-même en important le projet Android-studio.<br/>
Pour ce faire, vous devez télécharger android studio ici : <a href="https://developer.android.com/studio">Android-Studio</a><br/>
Vous devez ensuite lancer Android Studio, et faire attention à bien importer le projet situé ici :  ari_project/android_app/Anrdoid_Studio_Project <br/>

Puis passer votre téléphone en mode développeur : 
  <a href="https://www.frandroid.com/comment-faire/tutoriaux/184906_comment-acceder-au-mode-developpeur-sur-android">Acceder au mode developpeur</a><br/>
Une fois les option développeur révélées, vous devez activer le "debogage USB" dans ces dernières.
  
Alors enfin, vous devriez pouvoir brancher votre téléphone à votre ordinateur via un cable USB,<br/>
(une fenêtre devrait s'ouvrir sur votre téléphone vous demandant d'autoriser le débogage USB sur cet ordinateur, cochez la case "toujours autoriser")<br/>
et vous pourrez alors cliquer sur l'onglet "Run" en haut, puis sur "Run App" (ou utiliser le raccourci Maj + F10).<br/>
L'application s'installera alors sur votre téléphone, et restera utilisable même une fois Android-studio fermé.<br/>
(Laissez le temps à l'application de s'installer, le premier build est toujours un peu long)<br/>
  
En cas d'erreur, vérifiez que votre téléphone est bien en mode débogage USB, et vérifiez dans le coin inférieur gauche d'Android-Studio dans l'onglet "build variants" <br/>
que la variante sélectionnée est bien la variante debug et non pas release. (car l'APK de la release n'est pas signé.)<br/>

Pour ce qui est de l'utilisation, l'application a pour but de scanner des codes QR, censés être disposés sur les Appareils Respiratoires isolants des pompiers.
(plus tard elle pourrait être en mesure de scanner d'autres objets comme les compresseurs ou les Centres de Secours, selon les perspectives d'évolution de l'app)<br/>

Une sécurité est mise en place pour éviter d'utiliser l'appli avec des codes QR ne commençant pas par "ARI", vous pouvez donc aller générer des codes QR sur le site <a href="https://www.the-qrcode-generator.com/">the-qrcode-generator</a> pour pouvoir utiliser l'application. (Attention au moment du scan à ne pas non plus trop approcher votre téléphone au code,<br/>
il n'est pas necessaire que le QR code remplisse totalement la fenêtre de scan affichée.)<br/>
