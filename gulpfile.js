var gulp = require('gulp');

// Build Path
var path = require('path');
const BUILD_PATH = path.join(__dirname, './target/classes/static');

// Globs
const GLOBS = {
	assets: ['src/main/resources/static/images/*'],
	js_jsx: ['src/main/javascript/**/*.+(js|jsx)'],
	scss: ['src/main/styles/**.*.+(scss)'],
	spec: ['src/test/javascript/**/*Spec.+(js|jsx)']
};

// Webpack Configuration
var webpack = require('webpack');
var webpackStream = require('webpack-stream');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var _ = require('lodash');

const WBBPACK_SRC_CONFIG = {
	module: {
		loaders: [
			{
				test: /\.jsx?$/,
				loader: 'babel-loader',
				exclude: /node_modules/,
				query: {
					presets: ['react', 'env']
				}
			}, {
				test: /\.json$/,
				loader: 'json-loader'
			}, {
				test: [/\.scss$/, /\.css$/],
				loader: ExtractTextPlugin.extract(
          {use: [{
              loader: "css-loader"
            }, {
              loader: "sass-loader"
            }],
            // use style-loader in development
            fallback: "style-loader"}
				)
			}, {
				test: /(icons|fonts)/,
				loader: 'url-loader'
			}, {
				test: /\.png$/,
				loader: 'url-loader?=mimetype=image/png'
			}
		]
	}, resolve: {
		extensions: ['.js', '.jsx', '.json', '.scss', '.css']
	}, plugins: [
    new ExtractTextPlugin('styles/bundle.css')
  ]
};

const WEBPACK_BUILD_CONFIG = _.merge({}, WBBPACK_SRC_CONFIG, {
	entry: './src/main/javascript/index.jsx',
	output: {filename: 'javascript/bundle.js'}
});

const WEBPACK_TEST_CONFIG = _.merge({}, WBBPACK_SRC_CONFIG, {
	output: {filename: 'spec.js'},
	externals: {
		'react/addons': true,
		'react/lib/ExecutionEnvironment': true,
		'react/lib/ReactContext': true,
	},
	node: {fs: 'empty'}
});

// Gulp tasks
var eslint = require('gulp-eslint');
var jasmineBrowser = require('gulp-jasmine-browser');
var plumber = require('gulp-plumber');

gulp.task('lint', () => {
	return gulp.src(GLOBS.js_jsx)
		.pipe(eslint())
		.pipe(eslint.format())
		.pipe(eslint.failAfterError());
});

gulp.task('headless', () => {
	return gulp.src(GLOBS.test)
		.pipe(webpackStream(WEBPACK_TEST_CONFIG))
		.pipe(jasmineBrowser.specRunner({console: true}))
});

gulp.task('test', () => {
	return gulp.src(GLOBS.spec)
		.pipe(webpackStream(_.merge({}, WEBPACK_TEST_CONFIG, {watch: true})))
		.pipe(jasmineBrowser.specRunner({}))
		.pipe(jasmineBrowser.server())
});

gulp.task('build', () => {
	return gulp.src(GLOBS.js_jsx)
		.pipe(webpackStream(WEBPACK_BUILD_CONFIG))
		.pipe(gulp.dest(BUILD_PATH))
});

gulp.task('watch', () => {
	return gulp.src(GLOBS.js_jsx)
		.pipe(plumber(() => {
			console.error(arguments)
		}))
		.pipe(webpackStream(_.merge({}, WEBPACK_BUILD_CONFIG, {
			watch: true,
			devtool: 'inline-source-map',
		})))
		.pipe(gulp.dest(BUILD_PATH))
});