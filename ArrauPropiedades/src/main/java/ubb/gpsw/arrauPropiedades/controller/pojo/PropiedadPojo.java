//package ubb.gpsw.arrauPropiedades.controller.pojo;
//
//import ubb.gpsw.arrauPropiedades.utilidades.ObjectUtil;
//
//import ubb.gpsw.arrauPropiedades.model.Propiedad;
//import ubb.gpsw.arrauPropiedades.model.Tipo;
//import ubb.gpsw.arrauPropiedades.model.Destinacion;
//import ubb.gpsw.arrauPropiedades.model.Inmobiliaria;
//
//public class PropiedadPojo {
//	// Atributos con el mismo nombre que tiene el formulario html que crea Propiedad
//	// Todos los atributos que estaran en la "vista"
//	
//	// Tipo
//	private int idTipo; //select de tipo propiedad
//	private String nombreTipo;
//	
//	//Inmobiliaria
//	private int idInmobiliaria; //select de inmobiliaria
//	private String nombre;
//	
//	//Destinación
//	private int idDestinacion; // select de destinación
//	private String nombreDestinacion;
//	
//	//Propiedad
//	private int idPropiedad;
//	private String nombrePropiedad;
//	private String imagen;
//	private int dimTerreno;
//	private int dimConstruccion;
//	private int numDormitorio;
//	private int numBanio;
//	private int numEstacionamiento;
//	private String region;
//	private String comuna;
//	private String ciudad;
//	private String calle;
//	private String numero;
//	private String numDepartamento;
//	private int precio;
//	private String descripcion;
//		
//	// Costructor vacio
//	public PropiedadPojo() {
//		super();
//	}
//
//	// Constructor de Propiedad
//	public PropiedadPojo(Propiedad propiedad) {
//		super();
//		
//		this.idTipo = propiedad.getTipo().getIdTipo();
//		this.nombreTipo = propiedad.getTipo().getNombreTipo();
//		
//		this.idInmobiliaria = propiedad.getInmobiliaria().getIdInmobiliaria();
//		this.nombre = propiedad.getInmobiliaria().getNombre();
//		
//		this.idDestinacion = propiedad.getDestinacion().getIdDestinacion();
//		this.nombreDestinacion = propiedad.getDestinacion().getNombreDestinacion();
//		
//		this.idPropiedad = propiedad.getIdPropiedad();
//		this.nombrePropiedad = propiedad.getNombrePropiedad();
//		this.imagen = propiedad.getImagen();
//		this.dimTerreno = propiedad.getDimTerreno();
//		this.dimConstruccion = propiedad.getDimConstruccion();
//		this.numDormitorio = propiedad.getNumDormitorio();
//		this.numBanio = propiedad.getNumBanio();
//		this.numEstacionamiento = propiedad.getNumEstacionamiento();
//		this.region = propiedad.getRegion();
//		this.comuna = propiedad.getComuna();
//		this.ciudad = propiedad.getCiudad();
//		this.calle = propiedad.getCalle();
//		this.numero = propiedad.getNumero();
//		this.numDepartamento = propiedad.getNumDepartamento();
//		this.precio = propiedad.getPrecio();
//		this.descripcion = propiedad.getDescripcion();
//				
//	}
//
//	// Funcion para obtener datos de propiedad
//	public Propiedad obtenerPropiedad() {
//		final Propiedad p = new Propiedad();
//		
//		if (!ObjectUtil.isNull(this.idTipo)) {
//			p.setTipo(new Tipo(this.idTipo));
//		}
//		
//		if (!ObjectUtil.isNull(this.idInmobiliaria)) {
//			p.setInmobiliaria(new Inmobiliaria(this.idInmobiliaria));
//		}
//		
//		if (!ObjectUtil.isNull(this.idDestinacion)) {
//			p.setDestinacion(new Destinacion(this.idDestinacion));
//		}
//		
//		p.setIdPropiedad(this.idPropiedad);
//		p.setNombrePropiedad(this.nombrePropiedad);
//		p.setImagen(this.imagen);
//		p.setDimTerreno(this.dimTerreno);
//		p.setDimConstruccion(this.dimConstruccion);
//		p.setNumDormitorio(this.numDormitorio);
//		p.setNumDormitorio(this.numDormitorio);
//		p.setNumEstacionamiento(this.numEstacionamiento);
//		p.setRegion(this.region);
//		p.setComuna(this.comuna);
//		p.setCiudad(this.ciudad);
//		p.setCalle(this.calle);
//		p.setNumero(this.numero);
//		p.setNumDepartamento(this.numDepartamento);
//		p.setPrecio(this.precio);
//		p.setDescripcion(this.descripcion);
//		
//		return p;
//	
//	}
//
//	// Getter & Setters
//	public int getIdTipo() {
//		return idTipo;
//	}
//
//	public void setIdTipo(int idTipo) {
//		this.idTipo = idTipo;
//	}
//
//	public String getNombreTipo() {
//		return nombreTipo;
//	}
//
//	public void setNombreTipo(String nombreTipo) {
//		this.nombreTipo = nombreTipo;
//	}
//
//	public int getIdInmobiliaria() {
//		return idInmobiliaria;
//	}
//
//	public void setIdInmobiliaria(int idInmobiliaria) {
//		this.idInmobiliaria = idInmobiliaria;
//	}
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public int getIdDestinacion() {
//		return idDestinacion;
//	}
//
//	public void setIdDestinacion(int idDestinacion) {
//		this.idDestinacion = idDestinacion;
//	}
//
//	public String getNombreDestinacion() {
//		return nombreDestinacion;
//	}
//
//	public void setNombreDestinacion(String nombreDestinacion) {
//		this.nombreDestinacion = nombreDestinacion;
//	}
//
//	public int getIdPropiedad() {
//		return idPropiedad;
//	}
//
//	public void setIdPropiedad(int idPropiedad) {
//		this.idPropiedad = idPropiedad;
//	}
//
//	public String getNombrePropiedad() {
//		return nombrePropiedad;
//	}
//
//	public void setNombrePropiedad(String nombrePropiedad) {
//		this.nombrePropiedad = nombrePropiedad;
//	}
//
//	public String getImagen() {
//		return imagen;
//	}
//
//	public void setImagen(String imagen) {
//		this.imagen = imagen;
//	}
//
//	public int getDimTerreno() {
//		return dimTerreno;
//	}
//
//	public void setDimTerreno(int dimTerreno) {
//		this.dimTerreno = dimTerreno;
//	}
//
//	public int getDimConstruccion() {
//		return dimConstruccion;
//	}
//
//	public void setDimConstruccion(int dimConstruccion) {
//		this.dimConstruccion = dimConstruccion;
//	}
//
//	public int getNumDormitorio() {
//		return numDormitorio;
//	}
//
//	public void setNumDormitorio(int numDormitorio) {
//		this.numDormitorio = numDormitorio;
//	}
//
//	public int getNumBanio() {
//		return numBanio;
//	}
//
//	public void setNumBanio(int numBanio) {
//		this.numBanio = numBanio;
//	}
//
//	public int getNumEstacionamiento() {
//		return numEstacionamiento;
//	}
//
//	public void setNumEstacionamiento(int numEstacionamiento) {
//		this.numEstacionamiento = numEstacionamiento;
//	}
//
//	public String getRegion() {
//		return region;
//	}
//
//	public void setRegion(String region) {
//		this.region = region;
//	}
//
//	public String getComuna() {
//		return comuna;
//	}
//
//	public void setComuna(String comuna) {
//		this.comuna = comuna;
//	}
//
//	public String getCiudad() {
//		return ciudad;
//	}
//
//	public void setCiudad(String ciudad) {
//		this.ciudad = ciudad;
//	}
//
//	public String getCalle() {
//		return calle;
//	}
//
//	public void setCalle(String calle) {
//		this.calle = calle;
//	}
//
//	public String getNumero() {
//		return numero;
//	}
//
//	public void setNumero(String numero) {
//		this.numero = numero;
//	}
//
//	public String getNumDepartamento() {
//		return numDepartamento;
//	}
//
//	public void setNumDepartamento(String numDepartamento) {
//		this.numDepartamento = numDepartamento;
//	}
//
//	public int getPrecio() {
//		return precio;
//	}
//
//	public void setPrecio(int precio) {
//		this.precio = precio;
//	}
//
//	public String getDescripcion() {
//		return descripcion;
//	}
//
//	public void setDescripcion(String descripcion) {
//		this.descripcion = descripcion;
//	}
//	
//}
