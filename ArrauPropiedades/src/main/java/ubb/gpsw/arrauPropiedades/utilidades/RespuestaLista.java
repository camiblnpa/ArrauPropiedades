package ubb.gpsw.arrauPropiedades.utilidades;

public class RespuestaLista<T>{
	private T data;
	private Integer status;
	private String mensaje;

	public RespuestaLista() {
		super();
	}
	
	/**
	 * @param data
	 *            <T>
	 * @param status
	 *            {@link Integer}
	 */
	public RespuestaLista(T data, Integer status) {
		super();
		this.data = data;
		this.status = status;
	}
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
