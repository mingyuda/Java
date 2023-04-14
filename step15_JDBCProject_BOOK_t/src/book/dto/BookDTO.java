package book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BookDTO {
	String 	title;
	String 	publisher;
	int 	price;
	String 	authorId;
	String 	isbn;
}
