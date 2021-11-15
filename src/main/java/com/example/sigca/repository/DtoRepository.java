package com.example.sigca.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.example.sigca.dto.ParticipacionDto;
import com.example.sigca.entity.AsistenciaRecurso;
import com.example.sigca.entity.Persona;


@Repository
public interface DtoRepository extends JpaRepository<AsistenciaRecurso, String> {
	
	@Query(value = "Select concat(tp.NO_PERSONA,' ',tp.AP_PATERNO ) PERSONA,tp.NO_CORREO CORREO,s.NO_SESION SESION, concat(SUM(rs.ES_ASISTENCIA),'/' ,s.NU_Recursos  ) Asistencia from tbl_asistencia_recurso rs join tbl_recurso r on rs.fk_recurso=r.id_recurso join tbl_sesion s  on r.FK_SESION=s.ID_SESION join tbl_socio ts on rs.FK_SOCIO=ts.ID_PERSONA join tbl_persona tp on ts.ID_PERSONA=tp.ID_PERSONA  join tbl_modulo tbm on s.FK_MODULO=tbm.ID_MODULO join tbl_bancocomunal tba on ts.FK_BANCOCOMUNAL=tba.ID_BANCOCOMUNAL  WHERE  tba.ID_BANCOCOMUNAL=?1 and tbm.ID_MODULO=?2  GROUP BY PERSONA, SESION;", nativeQuery = true)
	List<Map<String,Object>> listarDto(int bancocomunal,int modulo);
	
	
}
