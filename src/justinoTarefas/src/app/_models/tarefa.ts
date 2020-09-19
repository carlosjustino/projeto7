
import {Injectable} from "@angular/core";

@Injectable()
export class Tarefa {
    id: number;
    concluida: boolean ;
    descricao: string;
    titulo: string;
    numero: number;
}
