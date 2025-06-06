package com.fiap.global_solution_api.service;

import com.fiap.global_solution_api.dto.PostRequestDTO;
import com.fiap.global_solution_api.dto.PostResponseDTO;
import com.fiap.global_solution_api.mapper.PostMapper;
import com.fiap.global_solution_api.model.Post;
import com.fiap.global_solution_api.model.Usuario;
import com.fiap.global_solution_api.repository.PostRepository;
import com.fiap.global_solution_api.repository.UsuarioRepository;
import com.fiap.global_solution_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PostMapper mapper;

    public List<PostResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public Page<PostResponseDTO> findAllPageable(Pageable pageable){
        return repository.findAll(pageable)
                .map(mapper::toResponseDTO);
    }

    public PostResponseDTO findById(Long id){
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Post não encontrado: " + id));
    }

    public PostResponseDTO insert(PostRequestDTO dto){
        Post post = mapper.toEntity(dto);
        post.setDataCriacao(LocalDate.now());

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + dto.getIdUsuario()));
        post.setUsuario(usuario);
        return mapper.toResponseDTO(repository.save(post));
    }

    public PostResponseDTO update(Long id, PostRequestDTO dto){
        Post postExist = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post não encontrado: " + id));
        postExist.setTitulo(dto.getTitulo());
        postExist.setConteudo(dto.getConteudo());
        postExist.setSincronizado(dto.getSincronizado());

        Post postAtt = repository.save(postExist);
        return mapper.toResponseDTO(postAtt);
    }

    public void delete(Long id){
        Post post = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post não encontrado: " + id));
        repository.delete(post);
    }
}
