import { Component, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

export interface DialogData {
  mensagem: 'oi';
}


@Component({
  selector: 'confirm-dialog',
  templateUrl: 'confirmation-dialog.html',
})
export class ConfirmationDialog {
   constructor(@Inject(MAT_DIALOG_DATA) public data: DialogData,
   public dialogRef: MatDialogRef<ConfirmationDialog>) {}

   onNoClick(): void {
       this.dialogRef.close();
     }

}
