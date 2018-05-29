import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';

import {BlogAuthorModule} from './author/author.module';
import {BlogPostModule} from './post/post.module';
import {BlogCommentModule} from './comment/comment.module';
import {BlogTagModule} from './tag/tag.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */
import {HttpClientModule} from '@angular/common/http';

import {ApolloModule} from 'apollo-angular';


@NgModule({
    imports: [
        BlogAuthorModule,
        BlogPostModule,
        BlogCommentModule,
        BlogTagModule,
        HttpClientModule, // provides HttpClient for HttpLink
        ApolloModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BlogEntityModule {

}
