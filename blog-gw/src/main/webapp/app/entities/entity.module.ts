import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { BlogAuthorModule } from './author/author.module';
import { BlogPostModule } from './post/post.module';
import { BlogCommentModule } from './comment/comment.module';
import { BlogTagModule } from './tag/tag.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        BlogAuthorModule,
        BlogPostModule,
        BlogCommentModule,
        BlogTagModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BlogEntityModule {}
