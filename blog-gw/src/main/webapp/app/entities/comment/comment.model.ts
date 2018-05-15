import { BaseEntity } from './../../shared';

export class Comment implements BaseEntity {
    constructor(
        public id?: number,
        public text?: string,
        public authorId?: string,
        public postId?: string,
    ) {
    }
}
