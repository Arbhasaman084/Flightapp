import { BookService } from './../bookservice.service';
import { BorrowedService } from './../borrowed.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Books } from '../booklist/books';
import { Borrowed } from '../borrowed';

@Component({
  selector: 'app-returns',
  templateUrl: './returns.component.html',
  styleUrls: ['./returns.component.css']
})
export class ReturnsComponent implements OnInit {

  booklist: Books[] = [];
  borrowed: Observable<Borrowed[]>;

  book: Books = new Books();
  memId: number;
  currentUrl: string;
  borrow: Borrowed = new Borrowed();

  constructor(private router: Router, private activeRoute: ActivatedRoute,
    private borrowService: BorrowedService, private bookService: BookService) { }

  ngOnInit(): void {
    this.memId = this.activeRoute.snapshot.params.id;
    this.loadData(this.memId);
  }

  loadData(id: number) {
    this.borrowService.listBookForMember(id)
      .subscribe(data => {
        console.log(data);
        this.borrowed = data;
        for (let b of data) {
          this.bookService.getBookDetails(b.bookId)
            .subscribe(info => {
              console.log(info);
              this.book = info;
              this.booklist.push(this.book);
            });
        }
      }, error => console.log(error));
  }

  showBookDetails(id: number) {
    this.router.navigate(['/details', id, this.memId]);
  }

  returnBook(id: number) {
    this.borrowService.retrieveDetails(id)
      .subscribe(data => {
        console.log(data);
        this.borrow = data;

        this.bookService.getBookDetails(this.borrow.bookId)
        .subscribe(res => {
          console.log(res);
          this.book = res;
          this.book.availability = true;

          this.bookService.updateAvailability(this.book)
            .subscribe(res1 => {
              console.log(res1);
              alert(res1);
            });
        });

        this.borrowService.deleteBorrowedEntry(this.borrow.id)
          .subscribe(info => {
            console.log(info);
            alert(info);
            window.location.reload();
          })
      })
  }

  backToDash(){
    this.router.navigate(['/dash', this.memId]);
  }
}
