# TintoMax

Entidades:

	Usuario:
		Administrador:Se encargará de configurar la página, modificaciones …       		
    Cliente:Se logueará con su DNI y podrá ver su listado de pedidos, además del listado de precios.
		Anónimo:Solo podrá ver la página principal y el listado de precios.

Funcionalidad:
	
-Fichar:Pulsando el botón fichar se abre un pop-up donde mete su DNI y su clave,si no ha fichado antes ese día se crea la línea en la tabla con la hora y fecha del marcaje en “hora de inicio” y fecha. Si ya hay una entrada previa ese dia se preguntará si ha finalizado su jornada comenzada a las (hora de fichaje anterior) si pulsa NO no hay cambios, si pulsa SI se añade la hora en “hora fin”.
Si un día no cierra fichaje, al finalizar el día se añadirá en “hora fin” una hora posterior a la hora de fichaje (es decir, se cuenta que ha trabajado 1h).
-Crear Ticket:Se introduce el DNI del cliente, si no existe se abre un pop-up que preguntará si desea crear uno nuevo:
  -NO: se limpia el campo.
  -SI: se cierra el pop-up y se abre otro donde se creará el nuevo cliente.
	   Rellenar ticket:Una vez introducido el DNI, el administrador generará los datos de la factura, prenda con
