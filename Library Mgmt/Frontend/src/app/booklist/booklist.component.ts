import { BorrowedService } from './../borrowed.service';
import { Borrowed } from './../borrowed';
import { BookService } from './../bookservice.service';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Books } from './books';
import { Router, ActivatedRoute } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-booklist',
  templateUrl: './booklist.component.html',
  styleUrls: ['./booklist.component.css']
})
export class BooklistComponent implements OnInit {

  // id: number = 10;
  // title: string = "Harry Potter";
  // price: number = 390.00;
  // genre: string = "Fantasy";
  // status: boolean = false;

  // list: Array<Books> = new Array<Books>();
  // caption:string = "Borrow";

  booklist: Observable<Books[]>;

  book: Books = new Books();

  borrow: Borrowed = new Borrowed();

  avail: boolean = false;
  memId: number;

  pipe: DatePipe = new DatePipe('en-US');
  isDate = null;

  showAll: boolean = true;

  constructor(private bookService: BookService, private router: Router,
    private activeRoute: ActivatedRoute, private borrowService: BorrowedService) { }

  ngOnInit(): void {
    this.memId = this.activeRoute.snapshot.params.id;
    this.loadData();

    // this.list = [
    //   {id: 1, title: "Harry Potter And the Goblet of Fire", genre: 'Fantasy', price: 350.00, availability:true},
    //   {id: 2, title: "Dragon Fire", genre: 'Fantasy', price: 250.00, availability:true},
    //   {id: 3, title: "This is a Man", genre: 'Thriller', price: 390.00, availability:true},
    //   {id: 4, title: "Conjuring", genre: 'Horror', price: 430.00, availability:false},
    //   {id: 5, title: "Lady In Black", genre: 'Horror', price: 380.00, availability:true},
    //   {id: 6, title: "Lord Of Rings", genre: 'Fantasy', price: 320.00, availability:false},
    //   {id: 7, title: "Beauty and the Beast", genre: 'Romance', price: 240.00, availability:true}
    // ];

    // this.changeCaption();
  }

  loadData() {
    this.bookService.listAvailableBooks().subscribe(data => {
      console.log(data);
      this.booklist = data;
    })
  }

  // listAllBooks() {
  //   this.showAll = false;
  //   this.bookService.listAllBooks().subscribe(data => {
  //     console.log(data);
  //     this.booklist = data;
  //   });
  // }

  borrowBook(bId: number) {
    this.bookService.getBookDetails(bId)
      .subscribe(data => {
        console.log(data);
        this.book = data;
        this.book.availability = this.avail;
        this.saveBorrowDetails(this.book.bookId, this.memId);
        this.updateBookDetails();
        window.location.reload();
      }, error => console.log(error));
  }

  updateBookDetails() {
    this.bookService.updateAvailability(this.book)
      .subscribe(info => {
        console.log(info);
        alert(info);
      }, error => console.log(error));
  }

  saveBorrowDetails(id: number, mem: number) {
    this.isDate = this.pipe.transform(Date.now(), 'yyyy-MM-dd');

    this.borrow.bookId = id;
    this.borrow.memberId = mem;
    this.borrow.issueDate = this.isDate;
    this.borrow.dueDate = this.isDate;

    this.borrowService.saveBorrowedBook(this.borrow)
      .subscribe(data => {
        console.log(data);
        alert(data);
      });
  }

  // public showAlert(): void {
  //   alert("You clicked the borrow button");
  // }

  showBookDetails(id: number) {
    this.router.navigate(['/details', id, this.memId]);
  }

  backToDash(){
    this.router.navigate(['/dash', this.memId]);
  }

  // public changeCaption(): void {
  //   for(let i = 0; i < this.list.length; i++) {
  //     // this.list[i].availability == !this.list[i].availability;
  //     if(this.list[i].availability) {
  //       this.caption = 'Return';
  //     } else {
  //       this.caption = "Borrow";
  //     }
  //   }
  //}

}
