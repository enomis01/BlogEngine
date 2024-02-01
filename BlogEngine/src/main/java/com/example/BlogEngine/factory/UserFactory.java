package com.example.BlogEngine.factory;

import java.util.stream.Collectors;

import com.example.BlogEngine.dto.UserDTO;
import com.example.BlogEngine.entities.Article;
import com.example.BlogEngine.entities.Comment;
import com.example.BlogEngine.entities.User;

public class UserFactory {
    public static UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        // Imposta gli ID degli articoli e dei commenti dell'utente
        userDTO.setArticleIds(user.getArticles().stream().map(Article::getId).collect(Collectors.toList()));
        userDTO.setCommentIds(user.getComments().stream().map(Comment::getId).collect(Collectors.toList()));
        return userDTO;
    }

    public static User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        // Non impostiamo direttamente gli articoli e i commenti qui, dovremmo farlo
        // tramite i service
        return user;
    }
}
