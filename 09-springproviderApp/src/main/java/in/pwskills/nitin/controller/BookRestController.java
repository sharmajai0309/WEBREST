package in.pwskills.nitin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.entity.Book;

@RestController
@RequestMapping("/v1/api/book")
public class BookRestController {

	/*
	 * METHOD : GET
	 * PATH   : /showA
	 * R.T    : ResponseEntity<String>
	 * INPUT  : no input
	 */

	@GetMapping("/showA")
	public ResponseEntity<String> showMsg1() {
		//return new ResponseEntity<String>("WELCOME",HttpStatus.OK);
		return ResponseEntity.ok("WELCOME TO FIRST CALL TYPE - GET");
	}

	/*
	 * METHOD : GET
	 * PATH   : /showB
	 * R.T    : ResponseEntity<String>
	 * INPUT  : {id}/{name}
	 */
	@GetMapping("/showB/{id}/{name}")
	public ResponseEntity<String> showMsg2(
			@PathVariable Integer id,
			@PathVariable String name
	) {
		return ResponseEntity.ok("WELCOME TO FIRST CALL TYPE - GET ==> " + id + "-" + name);
	}

	/*
	 * METHOD : GET
	 * PATH   : /showC
	 * R.T    : ResponseEntity<Book>
	 * INPUT  : {id}
	 */

	@GetMapping("/showC/{id}")
	public ResponseEntity<Book> showMsg3(
			@PathVariable Integer id
	) {
		return ResponseEntity.ok(new Book(id, "DSA", "jai", 5000.0));
	}


	/*
	 * METHOD : POST
	 * PATH   : /showD
	 * R.T    : ResponseEntity<String>
	 * INPUT  : @RequestBody Book
	 */

	@PostMapping("/showD")
	public ResponseEntity<String> Showmsg4(
			@RequestBody Book book
	) {
		return ResponseEntity.ok("Data is given" + book);

	}

	/*
	 * METHOD : PUT
	 * PATH   : /showE
	 * R.T    : ResponseEntity<String>
	 * INPUT  : @RequestBody Book
	 */

	@PutMapping("/showE")
	public ResponseEntity<String> showmasg5(@RequestBody Book book) {
		return ResponseEntity.ok("Data from put is: " + book);
	}


	/*
	 * METHOD : DELETE
	 * PATH   : /showF
	 * R.T    : ResponseEntity<String>
	 * INPUT  : @RequestBody Book
	 */

	@PutMapping("/showF/{id}")
	public ResponseEntity<String> showmasg6(
			@PathVariable("id") Integer id

	) {
		return ResponseEntity.ok("Delete mapping is " + id);
	}

	@DeleteMapping("/showF/{id}")
	public ResponseEntity<String> showmsg4(
			@PathVariable Integer id) {

        return ResponseEntity.ok("Delete mapping done:" + id);
    }
}






