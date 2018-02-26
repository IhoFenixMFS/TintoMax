# TintoMax - Grupo 6
##**Componentes del Grupo**<p>
**Alejandro García Luna, a.garcialun@alumnos.urjc.es, AlejandroGarcíaLuna**</br>
**Marina Fernández Suárez, m.fernandezsu@alumnos.urjc.es, IhoFenixMFS**</br>
**Omar Khanji Dobosh, o.khanji.2016@alumnos.urjc.es, khenji55**</br>
**Álvaro Orbaneja Gómez, a.orbaneja@alumnos.urjc.es, Alvaro262**</br>
**Fenando Castro García, f.castrog@alumnos.urjc.es, fcastrog**</br>
<h2>Entidades:</h2> </br>

* **Usuario** </br>
* **Empleado** </br>
* **Prenda** </br>
* **Promoción** </br>
* **Fichar** </br>
* **Ticket** </br>
* **Factura** </br>
El Diagrama de la base de datos con dichas entidades se muestra acontinuación:</br>
![Diagrama de entidades de la Base de datos.](https://github.com/IhoFenixMFS/TintoMax/blob/master/d%20bd.jpg)

<h3>Usuario:</h3></br>

* **Administrador**: Se encargará de configurar la página, crear / modificar / eliminar promociones, subir fotos al carrusel, dar de alta / modificar / borrar empleados, prendas, etcétera.      </br>
* **Empleado**: Es el encargado de crear y modificar el estado de un ticket, además de poder acceder al listado detallado de tickets, imprimirlos, o buscar por cliente o número de ticket, modificar el estado de un ticket, y servirlo al cliente y cobrarlo. </br>
* **Cliente**: Se logueará con su DNI y podrá ver su listado de sus pedidos, tanto los ya recogidos como los que aún no ha recogido, además de descargarse el pdf de las facturas asociadas a los mismos, y tiene también todas las funciones del usuario anónimo.</br>
* **Anónimo**: Sólo podrá ver la página principal, los datos de como llegar e información del negocio y el listado de precios.</br>

<h3>Funcionalidad:</h3>
 *  **Crear Ticket**: Se introduce el DNI del cliente. Si no existe se abre un pop-up que preguntará si desea crear uno nuevo:</br>
     * NO: se limpia el campo.</br>
     * SI: se cierra el pop-up y se abre otro donde se creará el nuevo cliente.</br>
     * Rellenar ticket: Una vez introducido el DNI, el empleado generará los datos del ticket, imprimiéndolo al finalizar.</br>
 *  **Cambiar estado del ticket**: el empleado podrá cambiar el estado de _en proceso_ a _listo_ y posteriormente a _recogido_ al servir las prendas asociadas al ticket y cobrarlo. </br>
*  **Promociones**: El administrador podrá generar promociones, las cuales tras crearlas se notificarán a los clientes a la hora de realizar el ticket.</br>
*  ***Empleados**: El administrador podrádar de alta nuevos empleados rellenando los datos del formulario.</br>
*  **Clientes**: Tanto el administrador como el empleado podrán dar de alta a un nuevo cliente rellenando el formulario correspondiente. </br>
*  **Facturas**: El cliente desde el listado de tickets recpgidos podrá exportar un pdf con la factura asociada al ticket. </br>
 
<h3>Funcionalidad avanzada:</h3>
*  **Promociones**: El usuario administrador podrá añadir, modificar o eliminar promociones sobre una cantidad de una prenda concreta, aplicando en base a dicha promoción un descuento sobre el precio de esa cantidad de prendas. Al crear el ticket saldrá un pop-up con las promociones activas y preguntará si desea generar el ticket o volver atrás para modificar el ticket y que se apliquen las mismas. </br>

*  **Recordatorio**: Si han pasado 2 meses desde la fecha en que el ticket se ha cambiado a _listo_ se enviará un e-mail al cliente recordándole que tiene ese ticket pendiente de recogida. Al pasar 3 meses desde dicha fecha se avisará de que el ticket sufrirá un recargo por demora del 5% si no se recoge a lo largo de los 7 días siguientes. Cuando el ticket lleve 23 meses en estado _listo_ se avisará de la finalización del periodo legal de conservación de la prenda en el establecimiento y de que tiene un mes para recogerlo o tal y como indica la normativa se procederá a la "destrucción" de las prendas.
  
  <h3>Tecnologías:</h3>
  
 **Enlace a trello** https://trello.com/b/H1zxurzx
 
 <h4>Diagrama:</h4>
  
![diagram](https://user-images.githubusercontent.com/12202594/35738061-f6ddb7e0-082d-11e8-9ce4-cbcc76db0c09.png)


<h3>Configuración:</h3>

Se debe instalar mysql,configurarlo en las variables del path e inciarlo en el directorio del proyecto. Se lanzan las queries de la creación de la base de datos y tablas tras acceder desde ahí a mysql, y la query de inserción de datos. Posteriormente se ejecuta el aplication.java del proyecto, y se puede acceder ya con https://localhost:8080 a la aplicación.
