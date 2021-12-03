package com.example.sigca.serviceImpl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sigca.entity.BancoComunal;
import com.example.sigca.repository.BancoComunalRepositoy;
import com.example.sigca.service.BancoComunalService;

@Service
public class BancoComunalServiceImpl implements BancoComunalService {

	@Autowired
	private BancoComunalRepositoy b;

	@Override
	public List<BancoComunal> listarBancoComunal() {
		// TODO Auto-generated method stub
		return b.listarBancoComunal();
	}

	@Override
	public String insertarBanco(BancoComunal banco) {
		// TODO Auto-generated method stub
		return b.insertarBanco(banco.getNo_bancocomunal(), banco.getDistrito().getId_distrito(), banco.getAsesor().getId_persona());
	}

	@Override
	public BancoComunal buscarBanco(int id_bancocomunal) {
		// TODO Auto-generated method stub
		return b.buscarBanco(id_bancocomunal);
	}

	@Override
	public String eliminarBanco(int id_bancocomunal) {
		// TODO Auto-generated method stub
		return b.eliminarBanco(id_bancocomunal);
	}

	@Override
	public String actualizarBanco(BancoComunal banco) {
		// TODO Auto-generated method stub
		return b.actualizarBanco(banco.getId_bancocomunal(), banco.getNo_bancocomunal(),banco.getDistrito().getId_distrito(), banco.getAsesor().getId_persona());
	}

	@Override
	public List<BancoComunal> buscarDistrito(int id) {
		// TODO Auto-generated method stub
		return b.listarBancoComunalDistrito(id);
	}

	@Override
	public List<BancoComunal> listarBancoComunalSede(int id) {
		// TODO Auto-generated method stub
		return b.listarBancoComunalSede(id);
	}


	
}
