package com.mx.ReproductorPractica.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ReproductorPractica.Dao.AlbumDao;
import com.mx.ReproductorPractica.Dao.ArtistaDao;
import com.mx.ReproductorPractica.Dominio.Album;
import com.mx.ReproductorPractica.Dominio.Artista;
import com.mx.ReproductorPractica.Dto.AlbumDto;
import com.mx.ReproductorPractica.Dto.ArtistaDto;
import com.mx.ReproductorPractica.Respuesta.Respuesta;

@Service
public class ArtistaImpl implements ArtistaMetodos {

	@Autowired
	ArtistaDao artistaDao;

	@Autowired
	AlbumDao albumDao;

	@Override
	public Respuesta crear(ArtistaDto dto) {
		// 1. Validación
		if (dto.getNombre() == null || dto.getNombre().isEmpty()) {
			return new Respuesta("Error: El nombre es obligatorio", null, false);
		}

		// 2. MAPEO: DTO -> Entidad (Para guardar en Oracle)
		Artista artista = new Artista();
		artista.setNombre(dto.getNombre());
		artista.setGenero(dto.getGenero());
		artista.setFechaDebut(dto.getFechaDebut());

		if (dto.getAlbums() != null) {
			List<Album> listaAlbumes = new ArrayList<>();
			for (AlbumDto aDto : dto.getAlbums()) {
				Album album = new Album();
				album.setTitulo(aDto.getTitulo());
				album.setPrecio(aDto.getPrecio());
				album.setFechaLanzamiento(aDto.getFechaLanzamiento());
				album.setArtista(artista); // Mantenemos el vínculo para la DB
				listaAlbumes.add(album);
			}
			artista.setAlbums(listaAlbumes);
		}

		// 3. Persistencia
		Artista artistaGuardado = artistaDao.save(artista);

		// 4. MAPEO INVERSO: Entidad -> DTO (Para responder a React)
		ArtistaDto respuestaDto = new ArtistaDto();
		respuestaDto.setId(artistaGuardado.getId());
		respuestaDto.setNombre(artistaGuardado.getNombre());
		respuestaDto.setGenero(artistaGuardado.getGenero());
		respuestaDto.setFechaDebut(artistaGuardado.getFechaDebut());

		if (artistaGuardado.getAlbums() != null) {
			List<AlbumDto> listaDtos = new ArrayList<>();
			for (Album alb : artistaGuardado.getAlbums()) {
				AlbumDto albDto = new AlbumDto();
				albDto.setId(alb.getId());
				albDto.setTitulo(alb.getTitulo());
				albDto.setPrecio(alb.getPrecio());
				albDto.setFechaLanzamiento(alb.getFechaLanzamiento());
				// AQUÍ ESTÁ EL TRUCO: No hay campo 'artista' en AlbumDto,
				// por lo tanto, no hay recursión.
				listaDtos.add(albDto);
			}
			respuestaDto.setAlbums(listaDtos);
		}

		return new Respuesta("Artista y álbumes creados con éxito", respuestaDto, true);
	}

	@Override
	public Respuesta Editar(ArtistaDto dto) {
		Artista artista = artistaDao.findById(dto.getId()).orElse(null);
		if (artista == null) {
			return new Respuesta("No se puede editar un artista que no existe", false, null);
		}
		return null;
	}

	@Override
	public Respuesta buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Respuesta elimiar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Respuesta listar() {
		// 1. Obtener todas las entidades desde Oracle a través del DAO
		List<Artista> listaEntidades = artistaDao.findAll();

		// 2. Crear la lista de DTOs que enviaremos al frontend
		List<ArtistaDto> listaDtos = new ArrayList<>();

		// 3. Recorrer cada entidad para convertirla a DTO
		for (Artista artista : listaEntidades) {
			ArtistaDto dto = new ArtistaDto();
			dto.setId(artista.getId());
			dto.setNombre(artista.getNombre());
			dto.setGenero(artista.getGenero());
			dto.setFechaDebut(artista.getFechaDebut());

			// 4. Convertir la lista de Álbumes de esta entidad a AlbumDto
			if (artista.getAlbums() != null) {
				List<AlbumDto> listaAlbumDtos = new ArrayList<>();
				for (Album album : artista.getAlbums()) {
					AlbumDto aDto = new AlbumDto();
					aDto.setId(album.getId());
					aDto.setTitulo(album.getTitulo());
					aDto.setPrecio(album.getPrecio());
					aDto.setFechaLanzamiento(album.getFechaLanzamiento());

					// IMPORTANTE: Aquí no asignamos el artista al AlbumDto
					// para mantener el JSON limpio y sin bucles.
					listaAlbumDtos.add(aDto);
				}
				dto.setAlbums(listaAlbumDtos);
			}

			listaDtos.add(dto);
		}

		// 5. Retornar la respuesta con la lista de DTOs
		if (listaDtos.isEmpty()) {
			return new Respuesta("No hay artistas registrados", null, false);
		}

		return new Respuesta("Lista de artistas obtenida con éxito", listaDtos, true);
	}
}
