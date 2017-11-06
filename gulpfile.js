var gulp = require('gulp');

const GLOBS = {
	sass: ['./src/scss/**/*.scss'],
	js: ['./src/js/**/*.js'],
	jsx: ['./src/js/**/*.jsx']
};

// webpack stream
var path = require('path');
var webpack = require('webpack-stream');
gulp.task('webpack', function () {
	return gulp.src('src/main/javascript/app.js')
		.pipe(webpack({
			output: {
				path: path.join(__dirname, '/src/main/javascript'),
				filename: 'bundle.js'
			},
			module: {
				loaders: [
					{
						test: /\.jsx?$/,
						loader: 'babel-loader',
						exclude: /node_modules/,
						query: {
							cacheDirectory: true,
							presets: ['react', 'env']
						}
					}]
			}
		}))
		.pipe(gulp.dest('src/main/resources/static'));
});

// decompile scss into css
var sass = require('gulp-sass');
gulp.task('styles', function() {
	gulp.src('src/main/styles/main.scss')
		.pipe(sass().on('error', sass.logError))

		.pipe(gulp.dest('src/main/resources/static'));
});

gulp.task('watch', function() {
	gulp.watch('src/main/javascript/**/*')
});



// gulp.task('clean', function (cb) {
// 	require('rimraf')('dist', cb);
// });

// gulp.task('lint', function () {
// 	var jshint = require('gulp-jshint');
//
// 	return gulp.src('src/main/javascript/**/*.js')
// 		.pipe(jshint())
// 		.pipe(jshint.reporter('default'));
// });
//
// gulp.task('sass', function () {
// 	var sass = require('gulp-sass');
//
// 	return gulp.src('app/scss/*.scss')
// 		.pipe(sass({
// 			precision: 10
// 		}))
// 		.pipe(gulp.dest('app/styles'));
// });


//
// gulp.task('images', function () {
//     var cache = require('gulp-cache'),
//         imagemin = require('gulp-imagemin');
//
//     return gulp.src('app/images/**/*')
//         .pipe(cache(imagemin({
//             progressive: true,
//             interlaced: true
//         })))
//         .pipe(gulp.dest('dist/images'));
// });
//
// gulp.task('fonts', function () {
//     return gulp.src('app/styles/fonts/*')
//         .pipe(gulp.dest('dist/styles/fonts'));
// });
//
// gulp.task('misc', function () {
//     return gulp.src([
//         'app/*.{ico,png,txt}',
//         'app/.htaccess'
//     ])
//         .pipe(gulp.dest('dist'));
// });
//
// gulp.task('html', ['sass'], function () {
//     var uglify = require('gulp-uglify'),
//         minifyCss = require('gulp-minify-css'),
//         useref = require('gulp-useref'),
//         gulpif = require('gulp-if'),
//         assets = useref.assets();
//
//     return gulp.src('app/*.html')
//         .pipe(assets)
//         .pipe(gulpif('*.js', uglify()))
//         .pipe(gulpif('*.css', minifyCss()))
//         .pipe(assets.restore())
//         .pipe(useref())
//         .pipe(gulp.dest('dist'));
// });

// inject bower components
// gulp.task('wiredep', function () {
//     var wiredep = require('wiredep').stream;
//
//     gulp.src('app/scss/**/*.scss')
//         .pipe(wiredep({directory: 'app/bower_components'}))
//         .pipe(gulp.dest('app/styles'));
//
//     gulp.src('app/*.html')
//         .pipe(wiredep({
//             directory: 'app/bower_components'
//         }))
//         .pipe(gulp.dest('app'));
// });
//
// gulp.task('connect', function () {
// 	var connect = require('connect');
// 	var serveStatic = require('serve-static');
// 	var serveIndex = require('serve-index');
// 	var app = connect()
// 		.use(require('connect-livereload')({port: 35729}))
// 		.use(serveStatic('app'))
// 		.use(serveIndex('app'));
//
// 	require('http').createServer(app)
// 		.listen(9000)
// 		.on('listening', function () {
// 			console.log('Started connect web server on http://localhost:9000');
// 		});
// });

// gulp.task('serve', ['connect', 'sass'], function () {
// 	var livereload = require('gulp-livereload');
//
// 	livereload.listen();
//
// 	require('opn')('http://localhost:9000');
//
// 	// watch for changes
// 	gulp.watch([
// 		'app/*.html',
// 		'.tmp/styles/**/*.css',
// 		'src/main/javascript/**/*.js',
// 		'app/images/**/*'
// 	]).on('change', livereload.changed);
//
// 	gulp.watch('app/scss/**/*.scss', ['sass']);
// 	gulp.watch('bower.json', ['wiredep']);
// });
// gulp.task('build', ['lint', 'html', 'images', 'fonts', 'misc']);

// gulp.task('default', ['clean'], function () {
//     gulp.start('build');
// });