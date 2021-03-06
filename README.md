# javaMettreLaTable

Application réalisée en une semaine dans le cadre d'un projet universitaire.

Plus d'informations concernant le projet : _M2105-TP67-2019.pdf_

**Online javaDoc :** <https://adelourmel.github.io/javaMettreLaTable/>  

:warning: Afin d'utiliser **JSON**, nous avons utilisé deux librairies **JAR** situées dans le dossier **lib**.

Il faut donc ajouter ces librairies dans le classpath à la compilation et l'exécution :

**Linux :**

```bash
git clone https://github.com/Adelourmel/javaMettreLaTable
chmod +x run_linux.sh
./run_linux.sh
```
**Windows (PowerShell) :**

```
git clone https://github.com/Adelourmel/javaMettreLaTable
```

```bash
javac -cp "lib/*;class/" -d class/ .\src\model\*java;javac -cp "lib/*;class/" -d class/ .\src\control\*java .\src\view\*java;javac -cp "lib/*;class/" -d class/ .\src\*java;java -cp "lib/*;class/" Launcher
```

:warning: Le fichier .jar doit **obligatoirement** être situé dans le même dossier que le dossier **data** !

Réalisé par [@ADelourmel](https://github.com/Adelourmel), [@kernoeb](https://github.com/kernoeb) et [@Cayril](https://github.com/Cayril)

