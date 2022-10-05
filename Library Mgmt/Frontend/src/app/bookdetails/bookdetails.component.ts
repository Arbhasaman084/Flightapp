import { BookService } from './../bookservice.service';
import { Books } from './../booklist/books';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-bookdetails',
  templateUrl: './bookdetails.component.html',
  styleUrls: ['./bookdetails.component.css']
})
export class BookdetailsComponent implements OnInit {

  // id: number = 10;
  // title: string = "Harry Potter";
  // price: number = 390.00;
  // genre: string = "Fantasy";

  book: Books;
  id: number;
  memId: number;

  constructor(private bookService: BookService, private activeRoute: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.id = this.activeRoute.snapshot.params.id;
    this.memId = this.activeRoute.snapshot.params.val;
    this.showBookDetails(this.id);
  }

  showBookDetails(id: number) {
    this.bookService.getBookDetails(id)
      .subscribe(data => {
        console.log(data);
        this.book = data;
      }, error => console.log(error));
  }

  backToHome() {
    this.router.navigate(['/dash', this.memId]);
  }
}
