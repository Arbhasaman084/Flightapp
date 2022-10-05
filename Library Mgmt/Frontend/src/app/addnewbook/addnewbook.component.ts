import { Router } from '@angular/router';
import { BookService } from './../bookservice.service';
import { Component, OnInit } from '@angular/core';
import { Books } from '../booklist/books';

@Component({
  selector: 'app-addnewbook',
  templateUrl: './addnewbook.component.html',
  styleUrls: ['./addnewbook.component.css']
})
export class AddnewbookComponent implements OnInit {

  title: string = "";
  genre: string = "";
  price: number = 0;
  // id: number = 1;

  book: Books = new Books();

  constructor(private bookService: BookService, private router: Router) { }

  ngOnInit(): void {
  }

  addNewBook() {
    this.book.bookId = 1;
    this.book.title = this.title;

    // console.log(this.title);
    this.book.genre = this.genre;
    this.book.price = this.price;
    this.book.availability = true;

    this.bookService.createBook(this.book)
      .subscribe(data => {
        console.log(data);
        if (this.book.title == data.title) {
          alert("Book Added Successfully");
          this.title = '';
          this.genre = '';
          this.price = 0;
        }
      })
      // this.router.navigate(['/home']);
  }

  backToHome() {
    this.router.navigate(['/login']);
  }


  // public showBookDetails(): void {
  //   if (this.title == "" || this.genre == "" || this.price == 0) {
  //     alert("all fields are mandatory");
  //   } else {
  //     alert(this.title + ", " + this.genre + ", " + this.price);
  //   }
  // }
}
