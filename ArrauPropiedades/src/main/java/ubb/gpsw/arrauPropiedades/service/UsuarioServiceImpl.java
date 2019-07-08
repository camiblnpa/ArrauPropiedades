package ubb.gpsw.arrauPropiedades.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ubb.gpsw.arrauPropiedades.model.Usuario;
import ubb.gpsw.arrauPropiedades.repository.UsuarioRepository;
import ubb.gpsw.arrauPropiedades.utilidades.RespuestaService;

@Service
public class UsuarioServiceImpl extends RespuestaService<Usuario,Integer> implements UsuarioService {

	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Override
	public CrudRepository<Usuario, Integer> getDao() {
		return usuarioRepo;
	}
}
