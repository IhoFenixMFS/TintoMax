# TintoMax - Grupo 6
##**Componentes del Grupo**<p>
**Alejandro García Luna,a.garcialun@alumnos.urjc.es,AlejandroGarcíaLuna**</br>
**Marina Fernández Suárez,m.fernandezsu@alumnos.urjc.es,IhoFenix**</br>
**Omar Khanji Dobosh,o.khanji.2016@alumnos.urjc.es,khenji55**</br>
**Álvaro Orbaneja Gómez,a.orbaneja@alumnos.urjc.es,Alvaro262**</br>
**Fenando Castro García,f.castrog@alumnos.urjc.es**</br>
<h2>Entidades:</h2> </br>

* **Usuario**: </br>
* **Empleado**: </br>
* **Prenda**: </br>
* **Promoción**: </br>
* **Fichar**: </br>
* **Ticket**: </br>
* **Factura**: </br>

<h3>Usuario:</h3></br>

* Administrador: Se encargará de configurar la página, modificaciones …      </br> 		
* Cliente: Se logueará con su DNI y podrá ver su listado de pedidos,además del listado de precios.</br>
* Anónimo: Sólo podrá ver la página principal y el listado de precios.</br>

<h3>Funcionalidad:</h3>
	
  * **Fichar**: Pulsando el botón fichar se abre un pop-up donde mete su DNI y su clave. Si no ha fichado antes ese día se crea la línea en la tabla con la hora y fecha del marcaje en “hora de inicio” y fecha. Si ya hay una entrada previa ese dia se preguntará si ha finalizado su jornada comenzada a las (hora de fichaje anterior). Si pulsa "NO" no hay cambios, si pulsa "SI" se añade la hora en “hora fin”.
  Si un día no cierra fichaje, al finalizar el día se añadirá en “hora fin” una hora posterior a la hora de fichaje (es decir, se cuenta que ha trabajado 1h).</br>
  * **Crear Ticket**: Se introduce el DNI del cliente. Si no existe se abre un pop-up que preguntará si desea crear uno nuevo:</br>
    * NO: se limpia el campo.</br>
    * SI: se cierra el pop-up y se abre otro donde se creará el nuevo cliente.</br>
  * **Rellenar ticket**: Una vez introducido el DNI, el administrador generará los datos de la factura.</br>
  -Promociones: El administrador podrá generar promociones, las cuales se les notificarán a los clientes a la hora de realizar el pago.</br>
  * **Servicios**: El administrador podrá especificar los servicios que ofrece la tintonería.</br>
  * **Facturación**: Se mostrará el resumen de facturación mensual, pudiendo incluir alguna modificación temporal previa exportación del pdf.</br>
  * **Facturas**: Si el cliente lo solicita, se podrá exportar un pdf con la factura asociada a uno o varios tickets de ese mismo cliente, además de mandarla por e-mail.
  
  <h3>Funcionalidad avanzada:</h3>
	
  * **Promociones**: El usuario administrador podrá añadir, modificar o eliminar promociones sobre un determinado tipo de prendas aplicando en base a la regla indicada un descuento.</br>
  * **Historial empleado**: Se podrán consultar y/o modificar las horas de cada empleado (el administrador), o las propias, cada empleado.
  * **Recordatorio**: Si han pasado 2 meses desde la fecha de recogida se enviará un e-mail al cliente (si tiene) recordándole que tiene prendas pendientes de recogida. Si han pasado 3 meses desde la fecha de recogida se avisará de que el ticket sufrirá un recargo por demora. Un mes antes de cumplir la prenda 2 años se avisará de la finalización del periodo legal de conservación de la prenda en el establecimiento.
   <h3>Tecnologías:</h3>
   
   <h4>Diagrama</h4>
   ![diagram](https://user-images.githubusercontent.com/12202594/35738061-f6ddb7e0-082d-11e8-9ce4-cbcc76db0c09.png)
