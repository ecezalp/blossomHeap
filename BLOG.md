gulpfile

- extract text plugin for bunding css files into a single file

gulpfile extensions 
Yes. test: /.jsx?$/ should be the right way. But you also need to set resolve.extensions parameter to make it work.

module.exports = {
  ...
  resolve: {
    extensions: ['.js', '.jsx']
  }
  ...
}

// Refreshing static content with Spring MVC and Boot
(BUILD_PATH)