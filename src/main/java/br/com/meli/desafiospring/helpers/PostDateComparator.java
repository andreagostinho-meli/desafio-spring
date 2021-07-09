package br.com.meli.desafiospring.helpers;

import br.com.meli.desafiospring.dto.post.getpostsfromfollowedusers.PostFromFollowedUserDTO;

import java.time.LocalDate;
import java.util.Comparator;

public class PostDateComparator implements Comparator<PostFromFollowedUserDTO> {
    @Override
    public int compare(PostFromFollowedUserDTO post1, PostFromFollowedUserDTO post2) {
        String[] splittedDate1 = post1.getDate().split("-");
        String[] splittedDate2 = post2.getDate().split("-");

        String dayOfDate1 = splittedDate1[0];
        String monthOfDate1 = splittedDate1[1];
        String yearOfDate1 = splittedDate1[2];

        String dayOfDate2 = splittedDate2[0];
        String monthOfDate2 = splittedDate2[1];
        String yearOfDate2 = splittedDate2[2];

        LocalDate date1 = LocalDate.of(Integer.parseInt(yearOfDate1), Integer.parseInt(monthOfDate1), Integer.parseInt(dayOfDate1));
        LocalDate date2 = LocalDate.of(Integer.parseInt(yearOfDate2), Integer.parseInt(monthOfDate2), Integer.parseInt(dayOfDate2));

        return date1.compareTo(date2);
    }
}
