# Scala.js

### how to compile / run

#### fast build / non-optimized JS file
```shell
sbt "j01 / fastLinkJS"
open j01/target/scala-2.13/classes/index-dev.html
```

#### look what's compiled
```shell
cd j01
npm run start
```

#### longer build / optimized JS file
```shell
sbt "j01 / fullLinkJS"
open j01/target/scala-2.13/classes/index-prod.html
```

```shell
sbt "j02 / fastLinkJS"
open j02/target/scala-2.13/classes/index-dev.html
```

### links

- http://www.scala-js.org
- https://www.scala-js.org/doc/tutorial/basic
- http://lihaoyi.github.io/workbench-example-app/triangle.html
- http://lihaoyi.github.io/workbench-example-app/dodge.html
- http://lihaoyi.github.io/workbench-example-app/invaders.html
- http://lihaoyi.github.io/workbench-example-app/raytracer.html
- http://lihaoyi.github.io/workbench-example-app/map.html
- http://todomvc.com
