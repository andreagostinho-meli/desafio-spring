package br.com.meli.desafiospring.helpers;

import br.com.meli.desafiospring.dto.user.UserDTO;

import java.util.Comparator;

public class UserNameComparator implements Comparator<UserDTO> {
    @Override
    public int compare(UserDTO user1, UserDTO user2) {
        return user1.getUserName().compareTo(user2.getUserName());
    }
}
